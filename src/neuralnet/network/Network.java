/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnet.network;

import java.util.Random;

/**
 *
 * @author Sven Vissers
 */
public class Network
{

    private Input[][] nodes;

    public Network(int inputs, int[] hiddenLayers, int outputs)
    {
        GenerateNetwork(inputs, hiddenLayers, outputs);

        double[] testInputs = new double[inputs];

        for (int i = 0; i < inputs; i++)
        {
            testInputs[i] = new Random().nextDouble();
        }

        Run(testInputs);
    }

    public double[] Run(double[] inputs)
    {
        if (inputs.length != nodes[0].length)
        {
            throw new StringIndexOutOfBoundsException(String.format("Please give the network %s inputs to work with", nodes[0].length));
        }

        // Set inputs
        for (int i = 0; i < nodes[0].length; i++)
        {
            nodes[0][i].SetInput(inputs[i]);
        }
        
        double[] outputs = new double[nodes[nodes.length - 1].length];

        for (int o = 0; o < nodes[nodes.length - 1].length; o++)
        {

            outputs[o] = nodes[nodes.length - 1][o].GetOutput();

            System.out.println(String.format("Node %s outputs: %s", o, String.valueOf(outputs[o])));
        }
        
        return outputs;
    }

    /**
     * Generates the network based on the amount of layers and nodes in each
     * layer.
     *
     * @param inputs
     * @param hiddenLayers
     * @param outputs
     */
    private void GenerateNetwork(int inputs, int[] hiddenLayers, int outputs)
    {
        nodes = new Input[2 + hiddenLayers.length][];

        GenerateInputLayer(inputs);
        GenerateHiddenLayers(hiddenLayers);
        GenerateOutputLayer(outputs, hiddenLayers.length);
    }

    /**
     * Generates the input layer nodes
     *
     * @param inputs
     */
    private void GenerateInputLayer(int inputs)
    {
        nodes[0] = new Input[inputs];

        for (int i = 0; i < inputs; i++)
        {
            nodes[0][i] = new Input();
        }
    }

    /**
     * Generates the hidden layers and nodes inside those layers.
     *
     * @param hiddenLayers
     */
    private void GenerateHiddenLayers(int[] hiddenLayers)
    {
        for (int l = 1; l < hiddenLayers.length + 1; l++)
        {
            nodes[l] = new Input[hiddenLayers[l - 1]];

            for (int n = 0; n < hiddenLayers[l - 1]; n++)
            {
                Connection[] connections = GetConnections(nodes[l - 1]);

                nodes[l][n] = new Perceptron(connections);
            }
        }
    }

    /**
     * Generates the output layer nodes.
     *
     * @param outputs
     * @param hiddenLayerCount
     */
    private void GenerateOutputLayer(int outputs, int hiddenLayerCount)
    {
        nodes[hiddenLayerCount + 1] = new Input[outputs];
        for (int o = 0; o < outputs; o++)
        {
            Connection[] connections = GetConnections(nodes[hiddenLayerCount]);
            nodes[hiddenLayerCount + 1][o] = new Perceptron(connections);
        }
    }

    /**
     * Generates and returns all connections from an array of input nodes.
     *
     * @param inputNodes
     * @return connections
     */
    private Connection[] GetConnections(Input[] inputNodes)
    {
        Connection[] connections = new Connection[inputNodes.length];

        for (int c = 0; c < inputNodes.length; c++)
        {
            connections[c] = new Connection(inputNodes[c]);
        }

        return connections;
    }
}
