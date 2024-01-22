from mongoengine import *
from enum import Enum
from pprint import *

client = connect(host="mongodb+srv://psotil:QiJLhIdJeQ9pOlk1@elclusterdefinitivo.9cbognj.mongodb.net/project")


#TODO ESTO PARA LA COLLECTION MOVES
class FastMove(EmbeddedDocument):
    movetype = StringField(default="Fast")
    energyCost = IntField(max_length=100, min_length=33)
class ChargedMove(EmbeddedDocument):
    movetype = StringField(default="Charged")
    energyGain =IntField(max_length=20, min_length=0)
class Moves(Document):
    name = StringField()
    about = StringField()
    damage = IntField(max_length=180, min_length=0)
    damageType = ListField()
    fastMove = EmbeddedDocumentField(FastMove)
    chargedMove = EmbeddedDocumentField(ChargedMove)

#COLLECTION TEAM
class Team:
    name = StringField()
    catch_date = DateField()

