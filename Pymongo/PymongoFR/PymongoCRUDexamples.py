from pymongo import *
from pprint import pprint

#CONEXION AL CLUSTER
client = MongoClient("mongodb+srv://psotil:QiJLhIdJeQ9pOlk1@elclusterdefinitivo.9cbognj.mongodb.net/")
#ESCOJO BASE DE DATOS
db = client.sample_guides
# ESCOJO COLECTION
collection = db.planets

#SELECTS
#EN EL PARENTESIS PUEDE ESCRIBIR LA SINTAXIS PARA BUSCAR COMO EN COMPASS
planets = collection.find()
planet = collection.find_one()

#UNO SOLO
print("Solo uno, el pobre ta solo")
pprint(planet)

#TODOS
print("Toda la gang")
for planet in planets:
    pprint(planet)


#INSERT - ONE/MANY
planetitaNuevo = {
    "name":"Nastrodomus",
    "hasRings":True,
    "mainAtmosphere":["A","O"],
    "orderFromSun":999
}
collection.insert_one(planetitaNuevo)
#COMPROVACION
planet = collection.find_one({"name":"Nastrodomus"})
pprint(planet)

arrayPlanetas = [
    {
        "name": "Teyvat",
        "hasRings": False,
        "mainAtmosphere": ["Br", "O"],
        "orderFromSun": 34
    },
    {
        "name": "EntittyFramework",
        "hasRings": True,
        "mainAtmosphere": ["A", "Z"],
        "orderFromSun": 38
    }
]
collection.insert_many(arrayPlanetas)
#DELETE - ONE/MANY
collection.delete_one({"name":"Nastrodomus"})

#UPDATES - ONE/MANY
collection.update_one({"name":"Teyvat"}, {"$set":{"name":"JariloVI"}})
