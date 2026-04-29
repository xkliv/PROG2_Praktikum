class PalindromRekursiv implements Palindrom {

    @Override
    public boolean istPalindrom(String wort) {

        if (wort == null || wort.isEmpty()) {
            return false;
        }

        return pruefe(wort, 0, wort.length() - 1);
    }

    private boolean pruefe(String wort, int i, int j) {

        if (i >= j) {
            return true;
        }

        if (wort.charAt(i) != wort.charAt(j)) {
            return false;
        }

        return pruefe(wort, i + 1, j - 1);
    }
}