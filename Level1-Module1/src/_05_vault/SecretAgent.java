package _05_vault;

public class SecretAgent {

	public int findCode(Vault v) {
		
		for (int i = 0; i < 1000000; i++) {
			if (v.tryCode(i)) {
				return i;
			}
		}
		
		return -1;
	}
}
