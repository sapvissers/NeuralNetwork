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
public class Perceptron extends Input
{

    private double bias;
    private Connection[] connections;

    public Perceptron(Connection[] connections)
    {
        this(connections, new Random().nextDouble() * 2 - 1);
    }

    public Perceptron(Connection[] connections, double bias)
    {
        this.connections = connections;
        this.bias = bias;
    }

    /**
     * Calculates the output value based on the sum of all connections and the
     * bias passing it through a sigmoid function.
     *
     * @return double
     */
    public double GetOutput()
    {
        double summation = bias;

        for (Connection connection : connections)
        {
            summation += connection.Calculate();
        }

        double result = Sigmoid(summation);

        return result;
    }

    /**
     * Basic sigmoid function taking
     *
     * @param x
     * @return double
     */
    private double Sigmoid(double x)
    {
        return 1 / (1 + Math.exp(-x));
    }
}
