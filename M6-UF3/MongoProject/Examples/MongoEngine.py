from enum import Enum

from mongoengine import *
from pprint import *
from datetime import datetime

client = connect(host="mongodb+srv://alma96:super3@atlascluster.kgkfpgn.mongodb.net/sample_mflix")

#Per fer servir els enum hem de generar una classe i fer que hereti de Enum
class Alma(Enum):
    GUAPA = "guapa",
    INTELIGENTE = "inteligente",
    JUANIA = "juania"


#Si volem insertar un Object com a atribut (i només com a atribut, sense collection propia) generem una classe que hereti de EmbeddedDocument
class Awards(EmbeddedDocument):
    wins = IntField()
    nominations = IntField()
    text = StringField()

class Viewer(EmbeddedDocument):
    rating = FloatField()
    numReviews = IntField()
    meter = IntField()

class Critic(EmbeddedDocument):
    rating = FloatField()
    numReviews = IntField()
    meter = IntField()


class Tomatoes(EmbeddedDocument):
    viewer = EmbeddedDocumentField(Viewer)
    dvd = DateField()
    critic = EmbeddedDocumentField(Critic)
    lastUpdated = DateField()
    rotten = IntField()
    production = StringField()
    fresh = IntField()


#Sempre que volguem generar una nova collection hem de crear una classe que la representi i hereti de Document:
class Movies(Document):
    plot = StringField()
    genres = ListField(StringField(max_length=20, min_length=1))
    runtime = IntField(min_value=1)
    rated = StringField()
    cast = ListField(StringField())
    num_mflix_comments = IntField()
    languages = ListField(StringField())
    awards = EmbeddedDocumentField(Awards)
    tomatoes = EmbeddedDocumentField(Tomatoes)
    alma = EnumField(Alma)

class Comments(Document):
    name = StringField()
    email = EmailField()
    #Podem relacionar documents entre si: Hem de marcar el camp com a "ReferenceField()"
    movie_id = ReferenceField(Movies)
    text = StringField()
    date = DateField()

movies = Movies(
    plot ="A boy meets a Heron and well...",
    genres=['Action', 'Adventure', 'Romance'],
    runtime=120,
    cast=['The Boy', 'The Heron'],
    num_mflix_comments=0,
    languages=['Spanish', 'Japanese', 'Quenya'],
    awards = Awards(wins=2000, nominations=5465130158, text="HA GANAO"),
    tomatoes = Tomatoes(viewer = Viewer(numReviews=1, rating=5.5, meter=23), dvd=datetime.now(), critic = Critic(numReviews=1, rating=5.5, meter=23), lastUpdated=datetime.now(), rotten=1)
)
#El metode save() serveix per guardar els documents generats
movies.save()


#Per obtenir tots els registres d'una collection:
#for movie in Movies.objects():
    #pprint(movie)

laMevaPeli = ""
#Per filtrar en la cerca de documents podem llençar el parametre que busquem a la funcio objects
#Existeixen operadors per a les query que podeu trobar a la documentacio de MongoEngine [https://docs.mongoengine.org/guide/querying.html#query-operators]
for movie in Movies.objects(plot = "A boy meets a Heron and well..."):
    pprint(movie.plot)
    laMevaPeli = movie

#Quan modifiquem un document que ja existeix a la nostra BBDD, només hem de fer un save() i ells s'encarrega de fer l'Update
laMevaPeli.plot = "A boy fall in loves with a Heron and they have violent *** in front of the whole nation of Japan"
laMevaPeli.save()

comment = Comments(movie_id = laMevaPeli, name="PolSotillos", email="psotillos@gmail.com", text="Aquesta peli em sembla molt didàctica i interessant. S'haurien de fer mes pelis aixi. Em sento molt representat amb el prota.", date=datetime.now())

comment.save()