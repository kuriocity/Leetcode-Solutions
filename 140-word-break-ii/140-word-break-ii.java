class Solution {
	public List<String> wordBreak(String s, List<String> wordDict) {
		List<String> list = new ArrayList<>();

		HashSet<String> set = new HashSet<>();
		for (String str: wordDict)
			set.add(str);
        HashMap<String,List<String>> map=new HashMap<>();
		return solve(s, set,map);
		//list;

	}

	//something should be returned if needs to be memoized!
	List<String> solve(String s, HashSet<String> set,HashMap<String,List<String>> map) {
		if(map.containsKey(s))
            return map.get(s);


		List<String> list = new ArrayList<>();
		for (int i = 0; i<s.length(); i++) {

			String str = s.substring(0, i + 1);

			if (set.contains(str)) {

				if (i == s.length() - 1) {
					list.add(str);
					return list;
				}
				List<String> rem = solve(s.substring(i + 1), set,map);
				for (String sentence: rem) {
					list.add(str + " " + sentence);
				}

			}
		}
		map.put(s,list);

		return list;
	}
}