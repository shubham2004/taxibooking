import pandas as pd
import numpy as np
import matplotlib.pyplot as plt 
from sklearn.preprocessing import MinMaxScaler
import tensorflow as tf

dataset_train= pd.read_csv("Google_Stock_Price_Train.csv")
train_set = dataset_train.iloc[:, 1:2].values

sc = MinMaxScaler(feature_range=(0,1))
train_set = sc.fit_transform(train_set)

x_train =[]
y_train =[]
for i in range(60 ,1258):
    x_train.append(train_set[i-60:i, 0])
    y_train.append(train_set[i,0])

x_train, y_train =  np.array(x_train), np.array(y_train)


x_trainT = np.reshape(x_train, (x_train.shape[0], x_train.shape[1], 1))

regressor  = tf.keras.models.Sequential()
regressor.add(tf.keras.layers.LSTM(units =150 , return_sequences = True , input_shape= (x_train.shape[1], 1)))
regressor.add(tf.keras.layers.Dropout(0.20))
regressor.add(tf.keras.layers.LSTM(units =150 , return_sequences = True ))
regressor.add(tf.keras.layers.Dropout(0.20))
regressor.add(tf.keras.layers.LSTM(units =150 , return_sequences = True ))
regressor.add(tf.keras.layers.Dropout(0.20))
regressor.add(tf.keras.layers.LSTM(units =150 , return_sequences = True ))
regressor.add(tf.keras.layers.Dropout(0.20))
regressor.add(tf.keras.layers.LSTM(units =150 , return_sequences = False ))
regressor.add(tf.keras.layers.Dropout(0.20))

regressor.add(tf.keras.layers.Dense(units=1)) 

regressor.compile(optimizer="Adam", loss="mse", metrics= ["mae","acc"])
regressor.fit(x_trainT, y_train, epochs=100, batch_size=64)



dataset_test = pd.read_csv('Google_Stock_Price_Test.csv')
real_stock_price = dataset_test.iloc[:, 1:2].values

# Getting the predicted stock price of 2017
dataset_total = pd.concat((dataset_train['Open'], dataset_test['Open']), axis = 0)
inputs = dataset_total[len(dataset_total) - len(dataset_test) - 60:].values
inputs = inputs.reshape(-1,1)
inputs = sc.transform(inputs)
X_test = []
for i in range(60, 80):
    X_test.append(inputs[i-60:i, 0])
X_test = np.array(X_test)
X_test = np.reshape(X_test, (X_test.shape[0], X_test.shape[1], 1))

predicted_stock_price = regressor.predict(X_test)
predicted_stock_price = sc.inverse_transform(predicted_stock_price)

plt.plot(real_stock_price, color = 'red', label = 'Real Google Stock Price')
plt.plot(predicted_stock_price, color = 'blue', label = 'Predicted Google Stock Price')
plt.title('Google Stock Price Prediction')
plt.xlabel('Time')
plt.ylabel('Google Stock Price')
plt.legend()
plt.show()

