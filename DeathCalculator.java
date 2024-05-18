public class DeathCalculator
{
	private int gender, diet, smoke, mHealth, sleep;
	private double weight, alcohol, fitness;
	public DeathCalculator()
	{
		gender = 0;
		weight = 0;
		diet = 0;
		smoke = 0;
		alcohol = 0;
		fitness = 0;
		mHealth = 0;
		sleep = 0;
	}
	public void setGender(int x)
	{
		gender = x;
	}
	public void setDiet(int x)
	{
		diet = x;
	}
	public void setWeight(double x)
	{
		weight = x;
	}
	public void setSmoke(int x)
	{
		smoke = x;
	}
	public void setAlcohol(double x)
	{
		alcohol = x;
	}
	public void setFitness(double x)
	{
		fitness = x;
	}
	public void setMHealth(int x)
	{
		mHealth = x;
	}
	public void setSleep(int x)
	{
		sleep = x;
	}
	public double calculateLifeExpectency()
	{
		return gender + weight + diet + smoke + alcohol + fitness + mHealth + sleep;
	}
}