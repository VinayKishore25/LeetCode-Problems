/**
 * @param {number} n
 * @return {Function} counter
 */
var createCounter = function(n) {
    var a = n - 1;
    
    return function() {
       
         return a = a + 1;
    };
};
/** 
 * const counter = createCounter(10)
 * counter() // 10
 * counter() // 11
 * counter() // 12
 */