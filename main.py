from fastapi import FastAPI
import pandas as pd
import sklearn.metrics as met
import numpy as np
from sklearn.model_selection import train_test_split, cross_val_score
from sklearn.linear_model import LinearRegression

app = FastAPI()
data = pd.read_csv('csv/combined.csv', sep=';')


def Essai(x):
    adresse_numero, type_local, surface_reelle_bati, nombre_pieces_principales, surface_terrain, longitude, latitude = x
    x_essai = [[adresse_numero, type_local, surface_reelle_bati, nombre_pieces_principales, surface_terrain, longitude,
                latitude]]
    x_essai = pd.DataFrame(x_essai,
                           columns=['adresse_numero', 'type_local', 'surface_reelle_bati', 'nombre_pieces_principales',
                                    'surface_terrain', 'longitude', 'latitude'])
    return x_essai

data = data.drop(
    ['code_postal', 'section_prefixe', 'id_parcelle', 'adresse_code_voie', 'adresse_nom_voie', 'date_mutation',
     'adresse_suffixe', 'id_mutation', 'nature_mutation', 'code_commune', 'code_departement', 'nombre_lots',
     'numero_disposition', 'code_commune', 'code_departement', 'nom_commune', 'ancien_code_commune',
     'ancien_nom_commune', 'ancien_id_parcelle', 'numero_volume', 'lot1_numero', 'lot1_surface_carrez', 'lot2_numero',
     'lot2_surface_carrez', 'lot3_numero', 'lot3_surface_carrez', 'lot4_numero', 'lot4_surface_carrez', 'lot5_numero',
     'lot5_surface_carrez', 'code_type_local', 'code_nature_culture', 'code_nature_culture_speciale', 'nature_culture',
     'nature_culture_speciale'], axis=1)

data.loc[data.type_local == 'Maison', 'type_local'] = '0'
data.loc[data.type_local == 'Appartement', 'type_local'] = '1'
data.loc[data.type_local == 'Local industriel. commercial ou assimilé', 'type_local'] = np.nan
data.loc[data.type_local == 'Dépendance', 'type_local'] = np.nan

data.dropna(inplace=True)
data = pd.DataFrame.reset_index(data, drop=True)

Q1 = np.percentile(data['valeur_fonciere'], 25, interpolation='midpoint')
Q3 = np.percentile(data['valeur_fonciere'], 75, interpolation='midpoint')
IQR = Q3 - Q1
upper = np.where(data['valeur_fonciere'] >= (Q3 + 32 * IQR))
lower = np.where(data['valeur_fonciere'] <= (Q1 - 1.3 * IQR))
data.drop(upper[0], inplace=True)
data.drop(lower[0], inplace=True)

data_train, data_test = train_test_split(data, train_size=0.7, test_size=0.3, random_state=10)
X_train = data_train
X_train = X_train.drop('valeur_fonciere', axis=1)
Y_train = data_train['valeur_fonciere']
X_test = data_test
X_test = X_test.drop('valeur_fonciere', axis=1)
Y_test = data_test['valeur_fonciere']
RegLin = LinearRegression()
scores = cross_val_score(RegLin, X_train, Y_train, cv=5)
RegLin.fit(X_train, Y_train)
Y_final = RegLin.predict(X_test)
r2 = met.r2_score(Y_test, Y_final)


def Esti(x):
    x = Essai(x)
    score = RegLin.predict(x)[0]
    return score

# @app.get("/")
# async def root():
#     return {file}
#
#
