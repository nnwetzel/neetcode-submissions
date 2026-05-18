class Solution {
    Map<Integer, List<Integer>> preMap = new HashMap<>();
    private Set<Integer> visiting = new HashSet<>();
    private Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) preMap.put(i, new ArrayList<>());
        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int pre = prereq[1];
            preMap.get(course).add(pre);
        }

        for (int c = 0; c < numCourses; c++) if (!dfs(c)) return false;
        return true;
    }

    public boolean dfs(int course) {
        if (visiting.contains(course)) return false;
        if (visited.contains(course)) return true;
        visiting.add(course);
        for (int pre : preMap.get(course)) if (!dfs(pre)) return false;
        visiting.remove(course);
        visited.add(course);
        return true;
    }
}
