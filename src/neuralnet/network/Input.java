/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnet.network;

/**
 *
 * @author Sven Vissers
 */
public class Input
{

    private double input;

    public Input()
    {
        this.input = 0;
    }

    public Input(double input)
    {
        this.input = input;
    }

    /**
     * Sets the input value.
     *
     * @param input
     */
    public void SetInput(double input)
    {
        this.input = input;
    }

    /**
     * Returns the output value
     *
     * @return double
     */
    public double GetOutput()
    {
        return input;
    }
}
