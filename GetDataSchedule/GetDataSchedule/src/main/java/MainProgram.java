import javax.swing.JOptionPane;

public class MainProgram {

	public void start() {
		try {
			if (!getConfig().isConfigOK()) {
				genConfigGUI = new GenConfigGUI(this, false);
				genConfigGUI.frame.setVisible(true);
			} else {
				schedulerGUI = new SchedulerGUI(this);
				schedulerGUI.frame.setVisible(true);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Configuration config;
	private GenConfigGUI genConfigGUI;
	private SchedulerGUI schedulerGUI;

	public MainProgram() {
		this.setConfig(new Configuration());
	}

	public static void main(String[] args) {
		System.out.println("YES");
		MainProgram mc = new MainProgram();
		mc.start();
		// testConnectMongo();
		// testGetHttpClient();
		// execute();
		// System.out.println(Config.url);
	}

	public void updateConfig(int hour, int minute, String url) {
		getConfig().updateConfig(url, hour, minute);
		this.start();
	}

	public void cancelUpdateConfig() {
		if (!getConfig().isConfigOK()) {
			JOptionPane.showMessageDialog(null, "Invalid Configuration. Exit now!", "Error", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		} else {
			this.start();
		}
	}

	public Configuration getConfig() {
		return config;
	}

	public void setConfig(Configuration config) {
		this.config = config;
	}

	public void updateEvent() {
		genConfigGUI = new GenConfigGUI(this, true);
		genConfigGUI.frame.setVisible(true);
		schedulerGUI.frame.setVisible(false);
	}
}
