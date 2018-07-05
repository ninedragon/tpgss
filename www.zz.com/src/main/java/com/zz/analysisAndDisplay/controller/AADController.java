package com.zz.analysisAndDisplay.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



import com.zz.analysisAndDisplay.utils.ThreadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zz.analysisAndDisplay.bo.WarnBO;
import com.zz.analysisAndDisplay.service.BoxWarnService;
import com.zz.common.controller.BaseController;
import com.zz.deviceAndData.service.DataCollectionService;

@Controller
@Scope(value = "prototype")
@RequestMapping("aad")
public class AADController extends BaseController {
    @Autowired
    DataCollectionService dataCollectionService;
    @Autowired
    BoxWarnService boxWarnService;

    //【1】表箱异常
    @RequestMapping(value = "boxWarn")
    public ModelAndView boxWarn(ModelMap modelMap) {
        ThreadUtils.printCurrentThreadname();
        return new ModelAndView("aad/boxWarn");
    }


    @RequestMapping(value = "listShortI", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> listShortI(WarnBO warnBO) {
        List<HashMap<String, Object>> list = boxWarnService.listShortI(warnBO);
        Integer count = list.size();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", count);
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "listLeakageI", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> listLeakageI(WarnBO warnBO) {
        List<HashMap<String, Object>> list = boxWarnService.listLeakageI(warnBO);
        Integer count = list.size();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", count);
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "listAbleakageI", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> listAbleakageI(WarnBO warnBO) {
        List<HashMap<String, Object>> list = boxWarnService.listAbleakageI(warnBO);
        Integer count = list.size();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", count);
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "listAbnormalU", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> listAbnormalU(WarnBO warnBO) {
        List<HashMap<String, Object>> list = boxWarnService.listAbnormalU(warnBO);
        Integer count = list.size();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", count);
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "listAbnormalZ", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> listAbnormalZ(WarnBO warnBO) {
        List<HashMap<String, Object>> list = boxWarnService.listAbnormalZ(warnBO);
        Integer count = list.size();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", count);
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "listPowerQuality", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> listPowerQuality(WarnBO warnBO) {
        List<HashMap<String, Object>> list = boxWarnService.listPowerQuality(warnBO);
        Integer count = list.size();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", count);
        map.put("rows", list);
        return map;
    }

    //【2】服务器发送事件 由于后来采用websocket，目前这个貌似没什么用了
//    @RequestMapping("getDate.json")
//    public void getDate(HttpServletResponse response, HttpServletRequest request) {
//
////		    Date date = new Date();
//        OutputStream bos = null;
//        //【1】加入观察者事件
//        BeingWatched beingWatched = new BeingWatched();//受查者
//        Watcher watcher = new Watcher();//观察者
//        beingWatched.addObserver(watcher);
//        beingWatched.counter(10);
//        //【2】服务器发送事件
//        try {
//
//            String result = "data:" + 111 + "\n\n";
//            String result2 = "data:" + 222 + "\n\n";
//            //声明浏览器在连接断开之后进行再次连接之前的等待时间 10秒
//            String retry = "retry:" + 50000 + "\n\n";
//            //事件的标识符
//            String id = "id:100\n\n";
//            //最后一次接收到的事件的标识符
//            String last = request.getHeader("Last-Event-ID");
//            logger.info(last);
//            bos = new BufferedOutputStream(response.getOutputStream());
//            response.setContentType("text/event-stream");
//            bos.write(result.getBytes());
//            bos.write(result2.getBytes());
//            bos.write(retry.getBytes());
//            bos.write(id.getBytes());
//            bos.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                bos.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
    /*main方法以后可能用到
     * public static void main(String[] args) throws Exception {
		SpringApplication.run(Example.class, args);
	}*/
}
