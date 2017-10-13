/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnet;

import neuralnet.network.Network;

/**
 *
 * @author Sven Vissers
 */
public class NeuralNet
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        GenerateNetwork();
    }

    public static void GenerateNetwork()
    {
        int[] hiddenLayers = new int[2];
        for (int i = 0; i < hiddenLayers.length; i++)
        {
            hiddenLayers[i] = 16;
        }

        new Network(784, hiddenLayers, 10);
    }

}
