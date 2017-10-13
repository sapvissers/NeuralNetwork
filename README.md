# NeuralNetwork
Java project for machine learning using a Neural Network

## What is a neural network?
A neural network is a commonly used model used in machine learning.
It is designed to work somewhat like the human brains do. A neural network has a layered structure.
The first layer is the input layer, then you have a variable amount of hidden layers, and at the end you have the output layer.

![usecase diagram](https://github.com/sapvissers/NeuralNetwork/blob/master/design/UseCaseDiagram.png)

Each layer consists of a number of nodes. For all layers except the input layer the are called perceptrons. These nodes work like a neuron in the human brain, taking all inputs from the previous layer and processing it into a single output to pass on to the next layer.

Each node in one layer is connected to all nodes in the next layer, nodes in the same layer are never connected. The connections are weighted connections, not all connections are equally important. This is the key to how the network works. By "learning" what weights are important the network can create a certain logic so that given a certain input, or group of inputs, the output is as desired.

Every perceptron also has a so called "bias", an extra number that provides a certain over-all compensation on the inputs it receives.
The perceptron calculates the output by adding up all inputs from the previous layer, multiplying each of them by their weight, then adding the bias to that sum. This will provide a number that needs to be passed to a sigmoid function to get a number between 0 and 1 to normalize the output.

In the equation below a represents a perceptron or input, (0) and (1) represent the layer the perceptron is in, W represents the weight and b represents the bias.


![perceptron](https://github.com/sapvissers/NeuralNetwork/blob/master/design/Perceptron.png)


## Learning algorithm
The learning algorithm is something that still needs to be created in this piece of software. We will present some training data to the network. This training data has given inputs and a desired output defined. By running this through the network that starts with random weights and biases it will certainly produce the wrong output at first. Then the network can compare the real output with the desired output and make slight changes in the weights to see if the error gets bigger or smaller. By getting the error smaller the network gets closer and closer to it's final form. When the error is small enough that we decide it's reliable the network is trained. This training data will be stored and can be loaded.

Next time the network receives an input it has never seen it'll pass that input through the network that outputs an answer that is pretty close because it has already seen comparable input and knows what it needed to do to get the desired output. Chances are this network will get the answer right a lot of the time, if only it has enough reliable training data and trained itself long enough.

## Class diagram
![class diagram](https://github.com/sapvissers/NeuralNetwork/blob/master/design/ClassDiagram.png)
