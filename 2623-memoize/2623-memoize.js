/**
 * @param {Function} fn
 * @return {Function}
 */
function memoize(fn) {
    var obj = {};
    return function(...args) {
        let n = JSON.stringify(args)
        if(obj[n]){
            return obj[n];
        }
        let res = fn(...args);
        obj[n] = res;
        return res;
    }
}


/** 
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1 
 */