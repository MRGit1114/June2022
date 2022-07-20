package DataProvider;

public enum DriverManagerFactory {
	
	CHROME { 
		@Override
		public DriverManager getDriverManager() {
			return new ChromeDriverManager();
		}
	},
	
	EDGE {
		@Override
		public DriverManager getDriverManager() {
			return new EdgeDriverManager();
		}
	};

	public abstract DriverManager getDriverManager();
}
