package org.pz.railway.test;

import java.util.ArrayList;
import java.util.List;

public class TestMain {
	TestMain() {
		tables.add("lteu1_dns_zc");
		tables.add("lteu1_email_zc");
		tables.add("lteu1_ftp_zc");
		tables.add("lteu1_http_zc");
		tables.add("lteu1_im_zc");
		tables.add("lteu1_mms_zc");
		tables.add("lteu1_p2p_zc");
		tables.add("lteu1_rtsp_zc");
		tables.add("lteu1_s1u_zc");
		tables.add("lteu1_voip_zc");
	}
	private List<String> tables = new ArrayList<String>();
	
	
	void outDeletePartition() {
		for(int m = 2; m <= 2; m++) {
		for(int i = 0; i <= 23; i++) {
			for(String table : tables) {
				System.out.println("alter TABLE pqtxdr." + table + " DROP PARTITION (startdate='201511" + (m < 10?0:"") + m + (i < 10 ? 0 : "") + i + "');");
			}
		}
		}
	}
	
	void outDeleteHdfsDir() {
		for(int m = 1; m <= 20; m++) {
		for(int i = 0; i <= 23; i++) {
			for(String table : tables) {
				System.out.println("hdfs dfs -rm -r -skipTrash /csv-pig/" + table + "/startdate=201602" + (m < 10?0:"") + m + (i < 10 ? 0 : "") + i);
			}
		}
		}
	}

	public static void main(String[] args) {
		TestMain t = new TestMain();
		t.outDeletePartition();
//		t.outDeleteHdfsDir();
	}
}
