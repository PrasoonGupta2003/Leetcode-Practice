public class CaptionToTag {
    public static String generateTag(String caption) {
        StringBuilder sb = new StringBuilder();
        sb.append('#');

        String[] words = caption.trim().split("\\s+");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.isEmpty()) continue;

            word = word.toLowerCase();

            if (i == 0) {
                sb.append(word);
            } else {
                sb.append(Character.toUpperCase(word.charAt(0)));
                sb.append(word.substring(1));
            }
        }

        // Remove non-letter characters except the first '#'
        for (int i = 1; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (!Character.isLetter(ch)) {
                sb.deleteCharAt(i);
                i--; // adjust index after removal
            }
        }

        // Truncate to max 100 characters
        if (sb.length() > 100) {
            sb.setLength(100);
        }

        return sb.toString();
    }
}
