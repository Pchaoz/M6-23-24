from enum import Enum

from mongoengine import *
from pprint import *
from datetime import datetime

# TODO ESTO PARA LA COLLECTION MOVES

class Type(Enum):
    BUG = "Bug",
    DARK = "Dark",
    DRAGON = "Dragon",
    ELECTRIC = "Electric",
    FAIRY = "Fairy",
    FIGHT = "Fight",
    FIRE = "Fire",
    FLYING = "Flying",
    GHOST = "Ghost",
    GRASS = "Grass",
    GROUND = "Ground",
    ICE = "Ice",
    NORMAL = "Normal",
    POISON = "Poison",
    PSYCHIC = "Psychic",
    ROCK = "Rock",
    STEEL = "Steel",
    WATER = "Water"


class Moves(EmbeddedDocument):
    name = StringField()
    about = StringField()
    pwr = IntField(max_length=180, min_length=0)
    type = EnumField(Type)


class FastMove(Moves):
    moveType = StringField(default="Fast")
    energyCost = IntField(max_length=100, min_length=33)


class ChargedMove(Moves):
    moveType = StringField(default="Charged")
    energyGain = IntField(max_length=20, min_length=0)


# POKEMON TEAM
class Pokemon(Document):
    num = IntField()
    name = StringField()
    img = StringField()
    type = ListField()
    height = StringField()
    weight = StringField()
    candy = StringField()
    candy_count = IntField()
    egg = StringField()
    spawn_chance = IntField()
    avg_spawns = IntField()
    spawn_time = StringField()
    multipliers = ListField()
    weaknesses = ListField()
    prev_evolution = ListField()
    next_evolution = ListField()


# COLLECTION TEAM
class Team(EmbeddedDocument):
    num = IntField()
    name = StringField()
    type = ListField()
    catch_date = DateField()


client = connect(host="mongodb+srv://psotil:QiJLhIdJeQ9pOlk1@elclusterdefinitivo.9cbognj.mongodb.net/project")

while True:
    user = input("FES LA TEVA CONSULTA (Catch, Update, Exit): ")
    userOption = user.split()

    if len(user) > 0:

        if userOption[0].lower() == "catch":
            print("Catch")

        elif userOption[0].lower() == "Update":
            print("Update")

    else:
        print("Escoje alguna opcion por dios")
