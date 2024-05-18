import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class HealthHack extends JFrame
{

	private Container contentPane = getContentPane();
	private JLabel greeting, text;
	private JPanel tips = new JPanel();
	private boolean gend = true;
	DeathCalculator deathCalc = new DeathCalculator();

	public HealthHack()
	{
        setTitle("Health Hack");
        setSize(1800, 750);
        UI();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
	}
	public void UI()
	{
		tips.setLayout(new BoxLayout(tips, BoxLayout.Y_AXIS));

		greeting = new JLabel("Life Clock");
		text = new JLabel("Gender?");
		greeting.setFont(new Font("Poppins", Font.BOLD, 100));
		text.setFont(new Font("Poppins", Font.BOLD, 20));

		JPanel buttonPannel = new JPanel(new FlowLayout(FlowLayout.CENTER,45,10));

		JButton male = new JButton("Male");
		JLabel malePict = new JLabel(new ImageIcon(resizeImage(getImage(1),125,180)));

		JPanel maleButton = new JPanel();
		maleButton.setLayout(new BoxLayout(maleButton, BoxLayout.Y_AXIS));

		maleButton.add(malePict);
		maleButton.add(male);

		JButton female = new JButton("Female");
		JLabel femalePict = new JLabel(new ImageIcon(resizeImage(getImage(2),160,180)));

		JPanel femaleButton = new JPanel();
		femaleButton.setLayout(new BoxLayout(femaleButton, BoxLayout.Y_AXIS));

		femaleButton.add(femalePict);
		femaleButton.add(female);

		buttonPannel.add(maleButton);
		buttonPannel.add(femaleButton);

		JPanel textPanel = new JPanel();
		JPanel weightChoice = new JPanel();
		textPanel.add(greeting);
		weightChoice.add(text);
		weightChoice.add(buttonPannel);

		JPanel combo = new JPanel();
		combo.setLayout(new BoxLayout(combo, BoxLayout.Y_AXIS));
		combo.add(textPanel);
		combo.add(weightChoice);

		contentPane.add(combo);

  		male.addActionListener(e -> {
			deathCalc.setGender(86);
			choices(weightChoice, combo, 1);
        });
  		female.addActionListener(e -> {
			deathCalc.setGender(89);
			gend = false;
			choices(weightChoice, combo, 1);
        });
	}
	public void choices(JPanel buttonPannel, JPanel combo, int slidNum)
	{
		buttonPannel.setVisible(false);

		JPanel buttonFoodPannel = new JPanel(new FlowLayout(FlowLayout.CENTER,45,10));
		JPanel superCombo = new JPanel();

		if(slidNum == 1)
		{
			text.setText("Please choose your BMI level");

			JLabel weightPic1 = new JLabel(new ImageIcon(resizeImage(getImage(3),140,130)));
			JLabel weightPic2 = new JLabel(new ImageIcon(resizeImage(getImage(4),160,180)));
			JLabel weightPic3 = new JLabel(new ImageIcon(resizeImage(getImage(5),160,180)));
			JLabel weightPic4 = new JLabel(new ImageIcon(resizeImage(getImage(6),180,180)));

			JButton weight1 = new JButton("Below 18.5"); // Underweight
			JButton weight2 = new JButton("18.5-24.9"); // Healthy Weight
			JButton weight3 = new JButton("25.0-29.9"); //Overweight
			JButton weight4 = new JButton("30.0 and Above"); //Obesity

			JPanel weightPanel1 = new JPanel();
			JPanel weightPanel2 = new JPanel();
			JPanel weightPanel3 = new JPanel();
			JPanel weightPanel4 = new JPanel();

			weightPanel1.setLayout(new BoxLayout(weightPanel1, BoxLayout.Y_AXIS));
			weightPanel2.setLayout(new BoxLayout(weightPanel2, BoxLayout.Y_AXIS));
			weightPanel3.setLayout(new BoxLayout(weightPanel3, BoxLayout.Y_AXIS));
			weightPanel4.setLayout(new BoxLayout(weightPanel4, BoxLayout.Y_AXIS));

			weightPanel1.add(weightPic1);
			weightPanel1.add(weight1);

			weightPanel2.add(weightPic2);
			weightPanel2.add(weight2);

			weightPanel3.add(weightPic3);
			weightPanel3.add(weight3);

			weightPanel4.add(weightPic4);
			weightPanel4.add(weight4);

			buttonFoodPannel.add(weightPanel1);
			buttonFoodPannel.add(weightPanel2);
			buttonFoodPannel.add(weightPanel3);
			buttonFoodPannel.add(weightPanel4);

			weight1.addActionListener(e -> {
				if(gend)
					deathCalc.setWeight(-4.3);
				else
					deathCalc.setWeight(-4.5);
				JLabel t = new JLabel("Underweight - Take in more calories than you burn in a day as part of a balanced diet.");
				JPanel p = new JPanel();
				p.add(t);
				tips.add(p);
				choices(superCombo, combo, 2);
			});
			weight2.addActionListener(e -> {
				choices(superCombo, combo, 2);
			});
			weight3.addActionListener(e -> {
				if(gend)
					deathCalc.setWeight(-3.15);
				else
					deathCalc.setWeight(-2.65);
				JLabel t = new JLabel("Overweight - Eat a healthy, reduced-calorie diet and exercise regularly.");
				JPanel p = new JPanel();
				p.add(t);
				tips.add(p);
				choices(superCombo, combo, 2);
			});
			weight4.addActionListener(e -> {
				if(gend)
					deathCalc.setWeight(-4.2);
				else
					deathCalc.setWeight(-3.5);
				JLabel t = new JLabel("Overweight - Eat a healthy, reduced-calorie diet and exercise regularly.");
				JPanel p = new JPanel();
				p.add(t);
				tips.add(p);
				choices(superCombo, combo, 2);
			});
		}

		if(slidNum == 2)
		{
			text.setText("How healthy is your diet?");

			JLabel dietPic1 = new JLabel(new ImageIcon(resizeImage(getImage(7),140,130)));
			JLabel dietPic2 = new JLabel(new ImageIcon(resizeImage(getImage(8),160,180)));
			JLabel dietPic3 = new JLabel(new ImageIcon(resizeImage(getImage(9),160,180)));
			JLabel dietPic4 = new JLabel(new ImageIcon(resizeImage(getImage(10),180,180)));

			JButton food1 = new JButton("I eat grass");
			JButton food2 = new JButton("Pretty healthy");
			JButton food3 = new JButton("Not so great");
			JButton food4 = new JButton("I eat borgor everyday");

			JPanel Panel1 = new JPanel();
			JPanel Panel2 = new JPanel();
			JPanel Panel3 = new JPanel();
			JPanel Panel4 = new JPanel();

			Panel1.setLayout(new BoxLayout(Panel1, BoxLayout.Y_AXIS));
			Panel2.setLayout(new BoxLayout(Panel2, BoxLayout.Y_AXIS));
			Panel3.setLayout(new BoxLayout(Panel3, BoxLayout.Y_AXIS));
			Panel4.setLayout(new BoxLayout(Panel4, BoxLayout.Y_AXIS));

			Panel1.add(dietPic1);
			Panel1.add(food1);

			Panel2.add(dietPic2);
			Panel2.add(food2);

			Panel3.add(dietPic3);
			Panel3.add(food3);

			Panel4.add(dietPic4);
			Panel4.add(food4);

			buttonFoodPannel.add(Panel1);
			buttonFoodPannel.add(Panel2);
			buttonFoodPannel.add(Panel3);
			buttonFoodPannel.add(Panel4);

			food1.addActionListener(e -> {
				deathCalc.setDiet(6);
				choices(superCombo, combo, 3);
			});
			food2.addActionListener(e -> {
				deathCalc.setDiet(4);
				choices(superCombo, combo, 3);
			});
			food3.addActionListener(e -> {
				JLabel t = new JLabel("Poor diet - Move away from unhealthy habits and replace it with new, healthy ones");
				JPanel p = new JPanel();
				p.add(t);
				tips.add(p);
				choices(superCombo, combo, 3);
			});
			food4.addActionListener(e -> {
				JLabel t = new JLabel("Poor diet - Move away from unhealthy habits and replace it with new, healthy ones");
				JPanel p = new JPanel();
				p.add(t);
				tips.add(p);
				deathCalc.setDiet(-4);
				choices(superCombo, combo, 3);
			});
		}

		if(slidNum == 3)
		{
			JLabel smokePic = new JLabel(new ImageIcon(resizeImage(getImage(11),90,180)));

			text.setText("Do you smoke?");
			JButton y = new JButton("Ya");
			JButton n = new JButton("Na");

			buttonFoodPannel.add(smokePic);
			buttonFoodPannel.add(y);
			buttonFoodPannel.add(n);

			y.addActionListener(e -> {
				deathCalc.setSmoke(-15);
				JLabel t = new JLabel("Smoking - In order to quit, seek for both medication and counseling");
				JPanel p = new JPanel();
				p.add(t);
				tips.add(p);
				choices(superCombo, combo, 4);
			});
			n.addActionListener(e -> {
				choices(superCombo, combo, 4);
			});
		}

		if(slidNum == 4)
		{
			JLabel drinkPic = new JLabel(new ImageIcon(resizeImage(getImage(12),90,180)));
			text.setText("Do you drink alcohol");
			JButton y = new JButton("Ya");
			JButton n = new JButton("Na");

			buttonFoodPannel.add(drinkPic);
			buttonFoodPannel.add(y);
			buttonFoodPannel.add(n);

			y.addActionListener(e -> {
			JLabel t = new JLabel("Drinking - If you're struggling with alcohol, try isolating yourself from activity with alcohol and seek counseling");
			JPanel p = new JPanel();
			p.add(t);
			tips.add(p);
			choices(superCombo, combo, 10);
			});

			n.addActionListener(e -> {
			choices(superCombo, combo, 5);
			});
		}

		if(slidNum == 10)
		{
			text.setText("How much alcohol do you drink");

			JButton alc1 = new JButton("7-10 drinks");
			JButton alc2 = new JButton("7-14 drinks");
			JButton alc3 = new JButton("14-19 drinks");
			JButton alc4 = new JButton("14-25 drinks");

			buttonFoodPannel.add(alc1);
			buttonFoodPannel.add(alc2);
			buttonFoodPannel.add(alc3);
			buttonFoodPannel.add(alc4);

			alc1.addActionListener(e -> {
				deathCalc.setAlcohol(-0.3);
				choices(superCombo, combo, 5);
			});
			alc2.addActionListener(e -> {
				deathCalc.setAlcohol(-0.6);
				choices(superCombo, combo, 5);
			});
			alc3.addActionListener(e -> {
				deathCalc.setAlcohol(-1);
				choices(superCombo, combo, 5);
			});
			alc4.addActionListener(e -> {
				deathCalc.setAlcohol(-2);
				choices(superCombo, combo, 5);
			});
		}

		if(slidNum == 5)
		{
			text.setText("How good is your Fitness?");

			JLabel fitPic = new JLabel(new ImageIcon(resizeImage(getImage(13),240,180)));

			JButton fitness1 = new JButton("King of Laziness");
			JButton fitness2 = new JButton("Quite active");
			JButton fitness3 = new JButton("Decently active");
			JButton fitness4 = new JButton("Very active");
			JButton fitness5 = new JButton("Master of working out");

			buttonFoodPannel.add(fitPic);
			buttonFoodPannel.add(fitness1);
			buttonFoodPannel.add(fitness2);
			buttonFoodPannel.add(fitness3);
			buttonFoodPannel.add(fitness4);
			buttonFoodPannel.add(fitness5);

			fitness1.addActionListener(e -> {
				JLabel t = new JLabel("Lack of exercise - Try to be physically active slowly and reward yourself to improve motivation");
				JPanel p = new JPanel();
				p.add(t);
				tips.add(p);
				deathCalc.setFitness(-1.3);
				choices(superCombo, combo, 6);
			});
			fitness2.addActionListener(e -> {
				JLabel t = new JLabel("Lack of exercise - Try to be physically active slowly and reward yourself to improve motivation");
				JPanel p = new JPanel();
				p.add(t);
				tips.add(p);
				deathCalc.setFitness(-1);
				choices(superCombo, combo, 6);
			});
			fitness3.addActionListener(e -> {
				choices(superCombo, combo, 6);
			});
			fitness4.addActionListener(e -> {
				deathCalc.setFitness(0.5);
				choices(superCombo, combo, 6);
			});
			fitness5.addActionListener(e -> {
				deathCalc.setFitness(0.5);
				choices(superCombo, combo, 6);
			});
		}

		if(slidNum == 6)
		{
			text.setText("How is your Mental Health?");

			JLabel healthPic = new JLabel(new ImageIcon(resizeImage(getImage(14),200,180)));

			JButton mental1 = new JButton("Thrilled");
			JButton mental2 = new JButton("Happy");
			JButton mental3 = new JButton("Joyful");
			JButton mental4 = new JButton("Neutral");
			JButton mental5 = new JButton("Sad");
			JButton mental6 = new JButton("Lets say really really bad");

			buttonFoodPannel.add(healthPic);
			buttonFoodPannel.add(mental1);
			buttonFoodPannel.add(mental2);
			buttonFoodPannel.add(mental3);
			buttonFoodPannel.add(mental4);
			buttonFoodPannel.add(mental5);
			buttonFoodPannel.add(mental6);

			mental1.addActionListener(e -> {
				deathCalc.setMHealth(5);
				choices(superCombo, combo, 7);
			});
			mental2.addActionListener(e -> {
				deathCalc.setMHealth(3);
				choices(superCombo, combo, 7);
			});
			mental3.addActionListener(e -> {
				deathCalc.setMHealth(1);
				choices(superCombo, combo, 7);
			});
			mental4.addActionListener(e -> {
				choices(superCombo, combo, 7);
			});
			mental5.addActionListener(e -> {
				JLabel t = new JLabel("Improving mental health - Try doing activites that helps you relax, reduce stress and make you happy");
				JPanel p = new JPanel();
				p.add(t);
				tips.add(p);
				deathCalc.setMHealth(-3);
				choices(superCombo, combo, 7);
			});
			mental6.addActionListener(e -> {
				JLabel t = new JLabel("Dealing with depression - Acknowledge what is making you depressed, find things that you enjoy and seek therapy if needed");
				JPanel p = new JPanel();
				p.add(t);
				tips.add(p);
				deathCalc.setMHealth(-5);
				choices(superCombo, combo, 7);
			});
		}

		if(slidNum == 7)
		{
			text.setText("How long do you sleep?");

			JLabel sleepPic = new JLabel(new ImageIcon(resizeImage(getImage(15),180,180)));

			JButton sleep1 = new JButton("I don't");
			JButton sleep2 = new JButton("1-3 hours");
			JButton sleep3 = new JButton("4-6 hours");
			JButton sleep4 = new JButton("7 or more hours");

			buttonFoodPannel.add(sleepPic);
			buttonFoodPannel.add(sleep1);
			buttonFoodPannel.add(sleep2);
			buttonFoodPannel.add(sleep3);
			buttonFoodPannel.add(sleep4);

			sleep1.addActionListener(e -> {
				JLabel t = new JLabel("Lack of sleep - Try to have sleeping schedule and seperate yourself from things that keeps you awake");
				JPanel p = new JPanel();
				p.add(t);
				tips.add(p);
				deathCalc.setSleep(-5);
				choices(superCombo, combo, 8);
			});
			sleep2.addActionListener(e -> {
				JLabel t = new JLabel("Lack of sleep - Try to have sleeping schedule and seperate yourself from things that keeps you awake");
				JPanel p = new JPanel();
				p.add(t);
				tips.add(p);
				choices(superCombo, combo, 8);
			});
			sleep3.addActionListener(e -> {
				if(gend)
					deathCalc.setSleep(3);
				else
					deathCalc.setSleep(1);
				choices(superCombo, combo, 8);
			});
			sleep4.addActionListener(e -> {
				if(gend)
					deathCalc.setSleep(5);
				else
					deathCalc.setSleep(2);
				choices(superCombo, combo, 8);
			});
		}

		if(slidNum == 8)
		{
			text.setText("Starting from age 0, you will live for "+ deathCalc.calculateLifeExpectency() +" years");
		}

		superCombo.add(text);
		superCombo.add(buttonFoodPannel);

		if(slidNum == 8)
			superCombo.add(tips);

		combo.add(superCombo);
	}
	public BufferedImage getImage(int whichImage)
	{
		switch (whichImage)
		{
			case 1:
				return loadImage("Boy.png");
			case 2:
				return loadImage("Girl.png");
			case 3:
				return loadImage("Chick1.png");
			case 4:
				return loadImage("Chick2.png");
			case 5:
				return loadImage("Chick3.png");
			case 6:
				return loadImage("Chick4.png");
			case 7:
				return loadImage("Food1.png");
			case 8:
				return loadImage("Food2.png");
			case 9:
				return loadImage("Food3.png");
			case 10:
				return loadImage("Food4.png");
			case 11:
				return loadImage("Thing.png");
			case 12:
				return loadImage("Drink.png");
			case 13:
				return loadImage("Lazy3.png");
			case 14:
				return loadImage("Emotion1.png");
			case 15:
				return loadImage("Sleep4.png");
			default:
				return loadImage("Boy.png");
		}
	}

	private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(getClass().getClassLoader().getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    private Image resizeImage(Image originalImage, int width, int height) {
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(originalImage, 0, 0, width, height, null);
        g2d.dispose();
        return resizedImage;
    }
    public static void main(String[] args)
	{
		HealthHack app = new HealthHack();
	}
}