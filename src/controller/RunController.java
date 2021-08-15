package controller;

public class RunController {

	// Chama novo processo
	public static void callProcess(String proc) {
		try {
			//System.out.println(proc);
			Runtime.getRuntime().exec(proc);
		} catch (Exception e) {
			// Erro de permissao no Windows
			if (System.getProperty("os.name").contains("Windows")) {
				if (e.getMessage().contains("740") && !proc.contains("cmd")) {
					StringBuffer sb = new StringBuffer();
					sb.append("cmd /c ");
					sb.append(proc);
					callProcess(sb.toString());
				}
			}
		}
	}
}
