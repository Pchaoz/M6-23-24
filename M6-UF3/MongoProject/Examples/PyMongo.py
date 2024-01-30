from pymongo import *
from pprint import pprint

#Per començar a treballar amb la nostra BBDD de MongoDB, hem de fer la connexio:
client = MongoClient("mongodb+srv://alma96:super3@atlascluster.kgkfpgn.mongodb.net/")

#A continuació hem de seleccionar quina database farem servir
db = client.sample_guides
#db = client["sample_guides"]

#Per ultim hem de seleccionar la collection amb la que volem treballar:
collection = db.planets
#collection = db["planets"]

#Per fer selects hem de fer servir el metode find() o find_one()
planets = collection.find()
planet = collection.find_one()

print("UN UNIC PLANETA:")
pprint(planet)

print("TOTS ELS PLANETES:")
for planet in planets: pprint(planet)

#Podem aplicar filtres de la mateixa manera que ho fem al Compass a les funcions d'operacions CRUD
LaTerra = collection.find_one({"name":"Earth"})
print("LA TERRA:")
pprint(LaTerra)

#Per fer un insert, de nou, tenim dos opcions en funcio de la quantitat d'elements que volem insertar (insert_one o insert_many)
newPlanet = {
    "name":"Raxacoricofallapatorius",
    "hasRings":False,
    "mainAtmosphere":['S','K','Au'],
    "orderFromSun":1000
}

collection.insert_one(newPlanet)
newPlanet = collection.find_one({"name":"Raxacoricofallapatorius"})
print("Raxacoricofallapatorius:")
pprint(newPlanet)

newPlanets = [
    {
        "name": "Alderaan",
        "hasRings": False,
        "mainAtmosphere": ['O', 'N', 'Ar'],
        "orderFromSun": 10000
    },
    {
        "name": "Namek",
        "hasRings": True,
        "mainAtmosphere": ['U', 'Fr', 'Br', 'B', 'Be'],
        "orderFromSun": -1
    }
]
collection.insert_many(newPlanets)

#Per esborrar documents de la nostra collection, de nou, tenim dos opcions: delete_one() o delete_many()
collection.delete_many({ "name":"Raxacoricofallapatorius" })
collection.delete_one({"name":"Alderaan"})

for i in collection.find():
    pprint(i)

#Per fer updates -> update_one() o update_many()
collection.update_one({"name":"Alderaan"}, {"$set":{"name":"Planeta Vegeta"}})
collection.update_many({"name":"Namek"},{"$set":{"hasRings": False}})










