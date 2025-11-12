package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2657 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int tc = Integer.parseInt(st.nextToken());
		
		for(int t=0; t<tc; t++) {
			st = new StringTokenizer(bf.readLine());
			
			int R = Integer.parseInt(st.nextToken());
			String[] S = st.nextToken().split("");
			
			StringBuilder P = new StringBuilder();
			
			for(int i=0; i<S.length; i++) {
				for(int j=0; j<R; j++) {
//					System.out.print(S[i]);
					P.append(S[i]);
				}
			}
			
			System.out.println(P.toString());
			
		}
		
	}

}
