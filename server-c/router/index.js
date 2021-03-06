const router = require('koa-router')();
const testCtl = require('../controller/testController');

router.prefix('/test');
router.get('/method-a',testCtl.getMethodA);
router.get('/method-b/:sleep',testCtl.getMethodB);
router.get('/method-c',testCtl.getMethodC);

module.exports= router;


