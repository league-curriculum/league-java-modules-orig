package _05_vault;

public class Runner {
	public static void main(String[] args) {
		
		SecretAgent jamesBond = new SecretAgent();
		Vault vault = new Vault();
		
		System.out.println(jamesBond.findCode(vault));
		
	}
}
