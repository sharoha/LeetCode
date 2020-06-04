var reverseString = function(s) {
    let i = 0;
    let j = s.length - 1;
    while (i <= j) {
        [s[i],s[j]] = [s[j],s[i]];
        i++;
        j--;
    }
    return s;   
};