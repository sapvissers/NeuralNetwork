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
public class Connection
{

    private double weight;
    private Input input;

    public Connection(Input input)
    {
        this(input, new Random().nextDouble() * 2 - 1);
    }

    public Connection(Input input, double weight)
    {
        this.input = input;
        this.weight = weight;
    }

    public void SetWeight(double weight)
    {
        this.weight = weight;
    }
    
    /**
     * Calculate the connected output based on the input times the weight.
     *
     * @return double
     */
    public double Calculate()
    {
        return input.GetOutput() * weight;
    }
}
