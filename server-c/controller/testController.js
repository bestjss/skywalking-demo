
class TestController {
    async getMethodA(ctx, next){
        ctx.body = 'this is Server C Method A'
    }

    async getMethodB(ctx, next){
        let sleep = ctx.params.sleep;
        ctx.body = 'this is Server C Method B' + sleep
    }

    async getMethodC(ctx, next){
        ctx.body = 'this is Server C Method C'
    }
}

module.exports= new TestController();