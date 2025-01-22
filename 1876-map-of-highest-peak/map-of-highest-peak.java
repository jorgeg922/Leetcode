class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int rows = isWater.length;
        int cols = isWater[0].length;
        int[][] peaks = new int[rows][cols];
        int[][] neighbors = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        Queue<int[]> locationsToExplore = new LinkedList<>();

        for(int[] entry : peaks){
            Arrays.fill(entry, -1);
        }

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(isWater[i][j]==1){
                    locationsToExplore.add(new int[]{i,j});
                    peaks[i][j] = 0;
                }
            }
        }

        int height = 1;

        while(!locationsToExplore.isEmpty()){
            int size = locationsToExplore.size();
            for(int i=0; i<size; i++){
                int[] currentLocation = locationsToExplore.poll();

                for(int[] neighbor : neighbors){
                    int nRow = currentLocation[0] + neighbor[0];
                    int nCol = currentLocation[1] + neighbor[1];

                    if(nRow < 0 || nRow >= rows || nCol < 0 || nCol >= cols){
                        continue;
                    }

                    if(peaks[nRow][nCol] != -1){
                        continue;
                    }

                    peaks[nRow][nCol] = height;
                    locationsToExplore.add(new int[]{nRow, nCol});

                }
            }

            height += 1;
        }

        return peaks;
    }
}