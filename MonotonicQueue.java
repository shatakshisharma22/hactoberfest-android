    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        boolean[]usedWorkerInFirstRound=new boolean[workers.length];
        int maxPossibleUsedTaskLen=Math.min(tasks.length,workers.length);
        int curToJudgeWorkIndex=0;
        for(int i=0;i<maxPossibleUsedTaskLen;i++){
            while (curToJudgeWorkIndex<workers.length&&workers[curToJudgeWorkIndex]<tasks[i]){
                curToJudgeWorkIndex++;
            }
            if(curToJudgeWorkIndex==workers.length){
                break;
            }
            usedWorkerInFirstRound[curToJudgeWorkIndex]=true;
            curToJudgeWorkIndex++;
        }
        for (int i=workers.length-1;i>=0;i--){
            if(pills==0){
                break;
            }
            if(!usedWorkerInFirstRound[i]){
                workers[i]+=strength;
                pills--;
            }
        }
        for (int i=workers.length-1;i>=0;i--){
            if(pills==0){
                break;
            }
            if(usedWorkerInFirstRound[i]){
                workers[i]+=strength;
                pills--;
            }
        }
        Arrays.sort(workers);
        int res=0;
        curToJudgeWorkIndex=0;
        for(int i=0;i<maxPossibleUsedTaskLen;i++){
            while (curToJudgeWorkIndex<workers.length&&workers[curToJudgeWorkIndex]<tasks[i]){
                curToJudgeWorkIndex++;
            }
            if(curToJudgeWorkIndex==workers.length){
                break;
            }
            res++;
            curToJudgeWorkIndex++;
        }
        return res;
    }
