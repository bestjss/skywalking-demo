const router = require('koa-router')();
const testCtl = require('../controller/testController');

router.prefix('/test');
router.get('/method-a',testCtl.getMethodA);
router.get('/method-b/:sleep',testCtl.getMethodB);
router.get('/method-c',testCtl.getMethodC);
router.get('/d/method-a',testCtl.getMethodAD);
router.get('/d/method-b/:sleep',testCtl.getMethodBD);
router.get('/d/method-c',testCtl.getMethodCD);

module.exports= router;


