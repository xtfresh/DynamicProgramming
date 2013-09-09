
public class Dynamic implements DynamicInterface {

	@Override
	public int lcs(String a, String b) {
		String str1 = a;
		String str2 = b;
		int[][] array = new int[a.length()+1][b.length()+1]; 
		
		for (int i = 0; i < array.length-1; i++)
			for (int j = 0; j< array[0].length-1; j++)
				if (str1.charAt(i) == str2.charAt(j)){
					array[i+1][j+1] = array[i][j] +1 ;		
				}else{
						array[i+1][j+1] = Math.max(array[i+1][j], array[i][j+1]); 
					}
		return array[array.length - 1][array[0].length - 1];
	}

	@Override
	public int edit(String a, String b) {
	    String str1 = a;
	    String str2 = b;

	    if(a == null && b == null)
            return 0;
 
        if(a == null && b != null)
            return b.length();
 
        if(a != null && b == null)
            return a.length();
 
        if(a.isEmpty() && b.isEmpty())
            return 0;
        if(a.isEmpty())
            return b.length();
        if(b.isEmpty())
            return a.length();
	    int[][] array = new int[a.length()+1][b.length()+1];
	    
	    for (int i = 0; i < array.length-1; i++)
	        array[i][0] = i;
	    for (int i = 0; i < array[0].length-1; i++)
	        array[0][i] = i;
	 
	    for (int i = 0; i < array.length-1; i++)
	        for (int j = 0; j < array[0].length-1; j++){
	        	int m = Math.min(array[i][j+1], array[i+1][j]) + 1;
	        	if (str1.charAt(i) == str2.charAt(j)){
	        		array[i+1][j+1] = Math.min(m, array[i][j]);
	        	}else{
	        		array[i+1][j+1] = Math.min(m, array[i][j]+1);
	        	}
	        }
	    
	    return array[array.length - 1][array[0].length - 1];
	}

	@Override
	public int shop(int[] weight, int[] value, int max) {
		int[] array = new int[max + 1];
		
		for(int i = 1; i <= max; i++){
			array[i] = array[i-1];
			for(int j = 0; j < weight.length; j++){
				if( i - weight[j] >= 0){
					array[i] = Math.max(array[i], array[i - weight[j]] + value[j]);
				}
			}
		}
		return array[max];
	}

	@Override
	public long matrix(int[] matrices) {
		int n = matrices.length - 1;
        int[][] matrix = new int[n][n];
        int[][] matrix2 = new int[n][n];
        int temp;
        int temp2;
 
        for(int i = 0; i < n; i++){
            matrix[i][i] = 0;
        }
 
        for(int index = 1; index < n; index++){
            for(int i = 0; i < n - index; i++){
                temp = i + index;
                matrix[i][temp] = Integer.MAX_VALUE;
                for(int k = i; k < temp; k++){
                    temp2 = matrix[i][k] + matrix[k + 1][temp] + (matrices[i] * matrices[k + 1] * matrices[temp + 1]);
                    if(temp2 < matrix[i][temp]){
                        matrix[i][temp] = temp2;
                        matrix2[i][temp] = k;
                    }
                }
            }
        }
 
        return matrix[0][matrix.length - 1];
	}

	@Override
	public int robbers(int[] weight, int[] value, int max) {
        
        int[][] optimal = new int [value.length+1][max+1];
       
        for(int i = 0; i < max+1; i++){
                optimal[0][i] = 0;
        }
       
        for(int i = 0; i < value.length+1; i++){
                optimal[i][0] = 0;
        }
       
        for(int i = 0; i < value.length; i++){
        	for(int j = 0; j < max+1; j++){
        		if(weight[i] <= j){
        			if(value[i] + optimal[i][j-weight[i]] > optimal[i][j]){
        				optimal[i+1][j] = value[i] + optimal[i][j-weight[i]];
        			}else{
        				optimal[i+1][j] = optimal[i][j];
        			}
        		}else{
        			optimal[i+1][j] = optimal[i][j];
        		}
        	}
        }

       
        return optimal[value.length][max];
       
	}

	@Override
	public int circus(String[] forest) {
		int max = 0;
		int[][] array =new int[forest.length][forest[0].length()];
		for(int i = 0; i < array.length; i++) {
			if(forest[i].charAt(0) == ',') {
				array[i][0] = 1;
			}
			max = Math.max(max, array[i][0]);
		}
		for(int j = 0; j < array[0].length; j++) {
			if(forest[0].charAt(j) == ',') {
				array[0][j] = 1;
			}
			max = Math.max(max, array[0][j]);
		}
		for(int i = 1; i < array.length; i++) {
			for(int j = 1; j < array[0].length; j++) {
				if(forest[i].charAt(j) == ',') {
					array[i][j] = Math.min(array[i-1][j], array[i][j-1]);
					if(forest[i - array[i][j]].charAt(j - array[i][j]) == ',') {
						array[i][j]++;
					}
					max = Math.max(max, array[i][j]);
				}
			}
		}
		return max*max;
	}

	@Override
	public int[] realEstate(String[] flatLand) {
		// TODO Auto-generated method stub
		return null;
	}

}
