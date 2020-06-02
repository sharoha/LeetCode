1467\. Probability of a Two Boxes Having The Same Number of Distinct Balls:
---
[Problem link](https://leetcode.com/contest/weekly-contest-191/problems/probability-of-a-two-boxes-having-the-same-number-of-distinct-balls/)  
Given ```2n``` balls of ```k``` distinct colors. You will be given an integer array `balls` of size
`k` where `balls[i]` is the number of balls of color `i`.  
You are given `two boxes`. All the balls are randomly shuffled uniformly, and distributed the first
`n` balls in the first box and the next `n` balls in the other box.  
_Calculate the probability_ that two boxes have the _same number of distinct balls_.

Idea
---
Probability=<img src="https://render.githubusercontent.com/render/math?math=\frac{Valid Comibination}{All Combination}">  
* We will try to generate all possible combination by recursion.
* Check if the combination is valid?
    * If valid, increment valid combination by 1
* Increment all combination by 1
* Return answer = valid / all

Problem faced
---
* Found difficulty while generating all possible combinations.