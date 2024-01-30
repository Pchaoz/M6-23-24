from pymongo import *
from pprint import pprint

# CONEXION AL CLUSTER
client = MongoClient("mongodb+srv://psotil:QiJLhIdJeQ9pOlk1@elclusterdefinitivo.9cbognj.mongodb.net/")
# ESCOJO BASE DE DATOS
db = client.project
# ESCOJO COLECTION
collectionP = db.pokemon
collectionT = db.team


def contains_int(string):
    if string[0].isnumeric():
        return True
    else:
        return False


while True:

    user = input("FES LA TEVA CONSULTA (Search, Release, Exit): ")
    userOption = user.split()
    if len(user) > 0:

        if userOption[0].lower() == "search":
            print("Search..")
            if contains_int(userOption[1]):
                # print("BUSQUEDA POR NUMERO")
                pokemon = collectionP.find_one({"num": userOption[1]})
                if len(userOption) < 2:
                    pprint(pokemon)
                else:
                    if userOption[2].lower() == "evol":
                        evolves = ""
                        for poke in pokemon["next_evolution"]:
                            evolves = evolves + " " + poke["name"]
                        print(pokemon["name"], ":", evolves)
                    else:
                        print(pokemon["name"], ": ", pokemon[userOption[2]])
            else:
                # print("BUSQUEDA POR STRING")
                pokemon = collectionP.find_one({"name": userOption[1]})
                if len(userOption) < 2:
                    pprint(pokemon)
                else:
                    if userOption[2].lower() == "evol":
                        evolves = ""
                        for poke in pokemon["next_evolution"]:
                            evolves = evolves + poke["name"]
                        print(pokemon["name"], ":", evolves)
                    else:
                        print(pokemon["name"], ":", pokemon[userOption[2]])

        elif userOption[0].lower() == "release":
            print("Release..")

            if contains_int(userOption[1]):
                print("RELEASE POR NUMERO")
                collectionT.delete_one({"num":userOption[1]})
            else:
                print("RELEASE POR STRING")
                collectionT.delete_one({"name": userOption[1]})

            teams = collectionT.find()
            print("RELEASED", userOption[1])
        elif userOption[0].lower() == "exit":
            print("Ad1os... ¯\_(ツ)_/¯")
            break
        else:
            print("Error, esta opcion no existe :c")
