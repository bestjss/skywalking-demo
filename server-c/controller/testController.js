const request = require('request')

class TestController {
    async getMethodA(ctx, next) {
        ctx.body = 'this is Server C Method A'
    }

    async getMethodB(ctx, next) {
        let sleep = ctx.params.sleep;
        ctx.body = 'this is Server C Method B' + sleep
    }

    async getMethodC(ctx, next) {
        ctx.body = 'this is Server C Method C'
    }

    async getMethodAD(ctx, next) {
        ctx.body =await get('http://localhost:8084/test/method-a')
    }

    async getMethodBD(ctx, next) {
        let sleep = ctx.params.sleep;
        ctx.body =await get('http://localhost:8084/test/method-b/' + sleep)
    }

    async getMethodCD(ctx, next) {
        ctx.body =await get('http://localhost:8084/test/method-c')
    }


}

const get = url =>
    new Promise((resolve, reject) =>
        request.get(url, (err, response, body) => {
            if (!err && response.statusCode == 200) {
                console.log(body);
                resolve(body);
            } else {
                reject(err);
            }
        })
    )

module.exports = new TestController();