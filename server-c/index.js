const koa = require('koa');
const router = require('koa-router')();
const bodyParser = require('koa-bodyparser');
const route = require('./router');

const app = new koa();

const index = router.get('/', async (ctx, next) => {
    ctx.response.body = `Hello, KOA2!`;
}).routes();

app.use(index);
app.use(bodyParser());
app.use(route.routes());

app.listen(8083);
console.log('Server C started at port 8083...');