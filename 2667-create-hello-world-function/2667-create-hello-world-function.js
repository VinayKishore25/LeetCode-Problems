/**
 * @return {Function}
 */
var createHelloWorld = function() {
    const val = () => {
        return "Hello World"
    }
    return val
};

/**
 * const f = createHelloWorld();
 * f(); // "Hello World"
 */