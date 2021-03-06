require('skyapm-nodejs').start({
    // Service name is showed in sky-walking-ui. Suggestion: set an unique name for each service, one
    // service's nodes share the same code.
    // this value cannot be empty.
    serviceName: 'server-c',
    // The identifier of the instance
    // Collector agent_gRPC/grpc service addresses.
    // default value: localhost:11800
    directServers: '127.0.0.1:11800'
});
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