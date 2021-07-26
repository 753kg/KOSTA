package step11_브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1018_answer {
	
	public static boolean[][] board;
	public static int min = 64;			// 8x8 board에서 다 다시쓴다면 최대 64
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		board = new boolean[N][M];
		
		// 체스판을 boolean 으로
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			
			for(int j=0; j<M; j++) {
				if(str.charAt(j) == 'B') board[i][j] = true;
				else board[i][j] = false;
			}
		}
		
		int repeatColNum = M - 8;	// 0 < i <= repeatColNum
		int repeatRowNum = N - 8;
		
		for(int row=0; row<=repeatRowNum; row++) {
			for(int col=0; col<=repeatColNum; col++) {
				getChangedNum(board, row, col);
			}
		}
		
		System.out.println(min);
	}
	
	public static void getChangedNum(boolean[][] board, int startRow, int startCol) {
		int endRow = startRow + 8;
		int endCol = startCol + 8;
		int count = 0;
		
		boolean mainColor = board[startRow][startCol];
		
		for(int i = startRow; i < endRow; i++) {
			for(int j = startCol; j < endCol; j++) {
				
				if(board[i][j] != mainColor) count++;
				mainColor = !mainColor;
			}
			
			mainColor = !mainColor;
		}
		
		count = Math.min(count, 64 - count);
		
		min = Math.min(count, min);

	}
}
