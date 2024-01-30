from enum import Enum
from datetime import datetime
import random

# MOVES COLLECTION

class Moves(EmbeddedDocument):
    name = StringField()
    about = StringField()
    damage = IntField(max_length=180, min_length=0)
    damageType = ListField()
    movetype = StringField()
    energyCost = IntField()


# COLLECTION TEAM
class Team(Document):
    num = IntField()
    name = StringField()
    img = StringField()
    type = ListField()
    catch_date = DateTimeField()
    cp = FloatField()
    hpmax = FloatField()
    hp = FloatField()
    atk = IntField()
    defense = IntField()
    energy = IntField()
    moves = ListField(EmbeddedDocumentField(Moves))
    candy = StringField()
    candy_count = FloatField()
    current_candy = FloatField()
    weaknesses = ListField(Enum)
    prev_evolution = ListField(ReferenceField(Document))
    next_evolution = ListField(ReferenceField(Document))


# COLLECTION POKEMON
class Pokemon(Document):
    num = IntField()
    name = StringField()
    img = StringField()
    type = ListField()
    height = StringField()
    weight = StringField()
    candy = StringField()
    candy_count = FloatField()
    egg = StringField()
    spawn_chance = FloatField()
    avg_spawns = IntField()
    spawn_time = StringField()
    multipliers = ListField()
    weaknesses = ListField()
    prev_evolution = ObjectIdField()
    next_evolution = ObjectIdField()


def contains_int(string):
    if string[0].isnumeric():
        return True
    else:
        return False


def pokeToTeam(p):
    maxHP = random.randint(200, 1000)
    rngAtk = random.randint(10, 50)
    rngDef = random.randint(10, 50)
    cp = maxHP + rngDef + rngAtk
    candyName = p["name"] + " Candy"
    print(candyName)

    move1 = Moves(name="Struggle",
                  about="Struggle is a Normal-type Main move in Pokémon GO that deals 35 damage and generates 0 energy. It is weak against Rock and Steel Pokémon.",
                  damage=35,
                  damageType=["Normnal"],
                  movetype="Fast",
                  energyCost=0)

    move2 = Moves(name="Origin Pulse",
                  about="Origin Pulse is a Water-type Main move in Pokémon GO that deals 130 damage and costs 100 energy. It is strong against Ground, Rock and Fire Pokémon and weak against Water, Grass and Dragon Pokémon.",
                  damage=130,
                  damageType=["Water"],
                  movetype="Charged",
                  energyCost=100)
    tp = Team(
        num=p["num"],
        name=p["name"],
        img=p["img"],
        type=p["type"],
        catch_date=datetime.now(),
        hpmax=maxHP,
        hp=maxHP,
        atk=rngAtk,
        defense=rngDef,
        cp=cp,
        energy=0,
        moves=[move1, move2],
        current_candy=0,
        candy=candyName,
        candy_count=15,
    )
    tp.save()


while True:
    user = input("FES LA TEVA CONSULTA (Catch, Update, Exit): ")
    userOption = user.split()

    if len(user) > 0:

        if userOption[0].lower() == "catch":
            print("Trying to catch", userOption[1], "...")
            pokeToCatch = ""
            pokeTeam = Team()
            for poke in Pokemon.objects(name=userOption[1]):
                print(poke.name)
                pk = poke
                pokeToTeam(pk)

        elif userOption[0].lower() == "update":
            print("Updating", userOption[1], "...")
            for poke in Team.objects(name=userOption[1]):
                pk = poke
                pk["current_candy"] = pk["current_candy"] + 1
                if pk["current_candy"] == pk["candy_count"] or pk["current_candy"] > pk["candy_count"]:
                    print("I have to evolve, but i can't sorry Alma he tenido problemas con las evoluciones")
                else:
                    print("Added one candy to", pk["name"], "current candies:", pk["current_candy"])
                pk.save()
        elif userOption[0].lower() == "exit":
            print("Closing program...")
            break

        else:
            print("Please, select a valid option..")

    else:
        print("Please, select a valid option..")
