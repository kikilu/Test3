public class Test3 {
    public static void main(String[] args){
        //练习-将每个单词的首字母大写
        String str = UpInitial("let there be light");
        System.out.println(str);

        //练习-统计有多少个以p开头的单词
        str = "peter piper picked a peck of pickled peppers";
        int count = countWords(str,'p');
        System.out.println(count);

        //练习-间隔大小写
        System.out.println(ulMod("lengendary"));

        //练习-将最后一个字母大写
        str = "lengendary";
        char[] strChar = str.toCharArray();
        strChar[strChar.length - 1] = Character.toUpperCase(strChar[strChar.length - 1]);
        str = new String(strChar);
        System.out.println(str);

        //练习-将最后一个two大写
        str = "Nature has given us that two ears, two eyes, and but one tongue, to the end that we should hear and see more than we speak";
        String[] strArray = str.split(" ");
        for (int i = strArray.length - 1;i > 0;i--){
            if (strArray[i].equals("two")) {
                strArray[i] = UpInitial(strArray[i]);
                break;
            }
        }
        System.out.println(strArryToStr(strArray));
    }

    //将首字母大写
    public static String UpInitial(String str){
        String[] subStr = str.split(" ");
        String str2return = "";
        for (String string : subStr){
            char[] cs = string.toCharArray();
            if (Character.isLetter(cs[0]) && cs[0] > 'Z')
            cs[0] -= 32;
            string = new String(cs);
            str2return += string + " ";
        }
        return str2return.trim();
    }

    //计算句子中有多少个规定首字母的单词
    public static int countWords(String sentence,char initial){
        int count = 0;
        String[] strArray = pickWords(sentence);
        for (String str : strArray){
            if (Character.toLowerCase(str.charAt(0)) == Character.toLowerCase(initial))
                count++;
        }
        return count;
    }

    //取出一段文字中的所有单词
    public static String[] pickWords(String sentence){
        //将句子转换为字符数组
        char[] letters = sentence.toCharArray();
        //将所得字符数组中的所有非字母字符转换为空格
        for (int i = 0;i < letters.length;i++){
            if (!Character.isLetter(letters[i]))
                letters[i] = ' ';
        }
        String sentenceTemp = new String(letters);
        //去掉转换后句子的首位空格
        sentenceTemp = sentenceTemp.trim();
        //将句子中连续的空格替换为单个空格
        sentenceTemp = sentenceTemp.replaceAll(" +"," ");
        //用空格对句子进行切分，得到单词数组
        String[] strTemp = sentenceTemp.split(" ");
        return strTemp;
    }

    //将单词改为间隔大写小写模式
    public static String ulMod(String word){
        String wordTemp = word.toLowerCase();
        char[] wordChar = wordTemp.toCharArray();
        for (int i = 0;i < wordChar.length;i += 2)
            wordChar[i] = Character.toUpperCase(wordChar[i]);
        return new String(wordChar);
    }

    public static String strArryToStr(String[] words){
        String scentence = "";
        for(String word:words)
            scentence += word + " ";
        return scentence;
    }
}
