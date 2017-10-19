package com.cryptobasket.web.crawler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is used for download Coin Logo from CoinMarketCap
 * 
 * @author mreko
 *
 */
public class CrawCoinIcon {
	private static final String iconUrl = "/currencies/[a-zA-Z_0-9-]{0,}/#markets";
	private static final String sourcePath = "/Users/mreko/git/crypto_basket_ui/cryptobasket/img/logo/32/";
	private static final String sourcePath64 = "/Users/mreko/git/crypto_basket_ui/cryptobasket/img/logo/64/";
	private static final String sourcePath128 = "/Users/mreko/git/crypto_basket_ui/cryptobasket/img/logo/128/";
	private static final String logoUrl = "https://files.coinmarketcap.com/static/img/coins/32x32/%s.png";
	private static final String logoUrl64 = "https://files.coinmarketcap.com/static/img/coins/64x64/%s.png";
	private static final String logoUrl128 = "https://files.coinmarketcap.com/static/img/coins/128x128/%s.png";
	private static final String tempFileName = "CoinsDownloaded";
	private static int start = 2000;
	private static int count = 0;
	private static int end = 8000;

	private static Set<String> coinNames;

	public static void main(String[] args) {
		try {
			loadCoinDownloadRecordFromFile();
		} catch (Exception ex) {
			coinNames = new LinkedHashSet<String>();
		}

		try {
			start("https://coinmarketcap.com/all/views/all/");
			report();
		} catch (Exception e) {
			report();
		}

		try {
			saveCoinDownloadRecordIntoFile();
		} catch (Exception ex) {
			System.out.println("Can not store CoinDownload Record");
		}
	}

	private static void report() {
		System.out.println("Start:" + start);
		System.out.println("End:" + end);
		System.out.println("Count:" + count);
	}

	public static void start(String allCoinsPageURL) throws Exception {

		URL uri = new URL(allCoinsPageURL);
		URLConnection connection = uri.openConnection();
		InputStream in = connection.getInputStream();
		byte[] buf = new byte[2048];
		int length = 0;
		StringBuffer sb = new StringBuffer();
		while ((length = in.read(buf, 0, buf.length)) > 0) {
			sb.append(new String(buf));
		}
		in.close();
		String page = sb.toString();

		// use regular expression to get coin name
		Matcher matcher = Pattern.compile(iconUrl).matcher(page);

		for (int i = start; i < end; i++) {

			if (matcher.find()) {
				String inconName = matcher.group().split("/")[2];
				if (!coinNames.contains(inconName)) {
					System.out.println(String.format(logoUrl, inconName));
					downloadLogo(String.format(logoUrl, inconName), sourcePath);
					// Thread.sleep(2000);
					downloadLogo(String.format(logoUrl64, inconName), sourcePath64);
					// Thread.sleep(2000);
					downloadLogo(String.format(logoUrl128, inconName), sourcePath128);
					// Thread.sleep(2000);
					count++;
					coinNames.add(inconName);
				}
			}
		}

		System.out.println("Total Icon:" + coinNames.size());
	}

	/**
	 * @param url
	 * @param sourcePath
	 *            /Users/mreko/git/crypto_basket_ui/cryptobasket/img/logo/
	 * @throws Exception
	 */
	public static void downloadLogo(String url, String sourcePath) throws Exception {
		try {
			String imageName = url.substring(url.lastIndexOf("/") + 1, url.length());

			String filePath = sourcePath + imageName;
			// check file if file is already exist, then skip
			File f = new File(filePath);
			if (f.exists() && !f.isDirectory()) {
				return;
			}

			// write image into current folder
			URL uri = new URL(url);
			InputStream in = uri.openStream();
			FileOutputStream fo = new FileOutputStream(new File(filePath));
			byte[] buf = new byte[1024];
			int length = 0;
			while ((length = in.read(buf, 0, buf.length)) != -1) {
				fo.write(buf, 0, length);
			}
			in.close();
			fo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void saveCoinDownloadRecordIntoFile() throws IOException {
		FileOutputStream fos = new FileOutputStream(tempFileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(coinNames);
		oos.close();
	}

	public static void loadCoinDownloadRecordFromFile() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(tempFileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		coinNames = (Set<String>) ois.readObject();
		ois.close();
	}
}
