package com.sig.fayi.controller;

import com.alibaba.fastjson.JSONObject;
import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.SimpleVoluntary;
import com.sig.fayi.exception.BaseExceptionHandleAction;
import com.sig.fayi.service.VoluntaryService;
import com.sig.fayi.utils.FileUploadUtil;
import com.sig.fayi.utils.LocationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/voluntary")
public class VoluntaryController extends BaseExceptionHandleAction {
    @Autowired
    private VoluntaryService voluntaryService;

    @ResponseBody
    @RequestMapping(value = "/findAllVoluntary")
    public ResultDto findAllVoluntary(){
        return voluntaryService.findAllVoluntary();
    }

    @ResponseBody
    @RequestMapping(value = "/findAllSimpleVoluntary")
    public ResultDto findAllSimpleVoluntary(HttpServletRequest request){
        String lng=request.getParameter("lng");
        String lat=request.getParameter("lat");
        return voluntaryService.findAllSimpleVoluntary(lat,lng);
    }

    @ResponseBody
    @RequestMapping(value = "/addVoluntary")
    public ResultDto addVoluntary(@RequestParam(value = "file") MultipartFile[] file, HttpServletRequest request) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SimpleVoluntary simpleVoluntary=new SimpleVoluntary();
        int organizationId=Integer.parseInt(request.getParameter("organizationId"));
        simpleVoluntary.setOrganizationId(organizationId);
//        Date siginUpStartTime=sdf.parse(request.getParameter("siginUpStartTime"));
        simpleVoluntary.setSiginUpStartTime(new Date());
        Date siginUpEndTime=sdf.parse(request.getParameter("siginUpEndTime"));
        simpleVoluntary.setSiginUpEndTime(siginUpEndTime);
        Date startTime=sdf.parse(request.getParameter("startTime"));
        simpleVoluntary.setStartTime(startTime);
        Date endTime=sdf.parse(request.getParameter("endTime"));
        simpleVoluntary.setEndTime(endTime);
        String chargeName=request.getParameter("chargeName");
        simpleVoluntary.setChargeName(chargeName);
        String chargePhone=request.getParameter("chargePhone");
        simpleVoluntary.setChargePhone(chargePhone);
        int peopleNum=Integer.parseInt(request.getParameter("peopleNum"));
        simpleVoluntary.setPeopleNum(peopleNum);
        simpleVoluntary.setSignUpNum(0);
        String address=request.getParameter("address");
        simpleVoluntary.setAddress(address);
        String addressLongitude=request.getParameter("addressLongitude");
        simpleVoluntary.setAddressLongitude(addressLongitude);
        String addressLatitude=request.getParameter("addressLatitude");
        simpleVoluntary.setAddressLatitude(addressLatitude);
        String voluntaryMore=request.getParameter("voluntaryMore");
        simpleVoluntary.setVoluntaryMore(voluntaryMore);
        String title=request.getParameter("title");
        simpleVoluntary.setTitle(title);
        simpleVoluntary.setCreateTime(new Date());
        System.out.println(addressLatitude+","+addressLongitude);
        JSONObject jsonObjectAdds= LocationUtil.getAddress(addressLongitude,addressLatitude);
        String province = jsonObjectAdds.getJSONObject("result").getJSONObject("addressComponent").getString("province");// 省
        String city = jsonObjectAdds.getJSONObject("result").getJSONObject("addressComponent").getString("city");// 市
        String district=jsonObjectAdds.getJSONObject("result").getJSONObject("addressComponent").getString("district");// 区
        simpleVoluntary.setProvince(province);
        simpleVoluntary.setCity(city);
        simpleVoluntary.setDistrict(district);
        if (file.length > 0) {
            String fileUUIDName= FileUploadUtil.uploadFile(file[0],request);
            simpleVoluntary.setVoluntaryCover(fileUUIDName);
            return voluntaryService.addVoluntary(simpleVoluntary);
        }else{
            return new ResultDto(200,"failure",null);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/findVoluntaryById")
    public ResultDto findVoluntaryById(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        return voluntaryService.findVoluntaryById(id);
    }

    @ResponseBody
    @RequestMapping(value = "/findVoluntaryByUserId")
    public ResultDto findVoluntaryByUserId(HttpServletRequest request){
        int userId=Integer.parseInt(request.getParameter("userId"));
        return voluntaryService.findVoluntaryByUserId(userId);
    }

    @ResponseBody
    @RequestMapping(value = "/findAllVoluntaryByOrgId")
    public ResultDto findAllVoluntaryByOrgId(HttpServletRequest request){
        int orgId=Integer.parseInt(request.getParameter("orgId"));
        return voluntaryService.findAllVoluntaryByOrgId(orgId);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteVoluntary")
    public ResultDto deleteVoluntary(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        return voluntaryService.deleteVoluntary(id);
    }

    @ResponseBody
    @RequestMapping(value = "/editVoluntary")
    public ResultDto editVoluntary(HttpServletRequest request) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SimpleVoluntary simpleVoluntary=new SimpleVoluntary();
        int id=Integer.parseInt(request.getParameter("id"));
        simpleVoluntary.setId(id);
        Date siginUpEndTime=sdf.parse(request.getParameter("siginUpEndTime"));
        simpleVoluntary.setSiginUpEndTime(siginUpEndTime);
        Date startTime=sdf.parse(request.getParameter("startTime"));
        simpleVoluntary.setStartTime(startTime);
        Date endTime=sdf.parse(request.getParameter("endTime"));
        simpleVoluntary.setEndTime(endTime);
        String chargeName=request.getParameter("chargeName");
        simpleVoluntary.setChargeName(chargeName);
        String chargePhone=request.getParameter("chargePhone");
        simpleVoluntary.setChargePhone(chargePhone);
        String address=request.getParameter("address");
        simpleVoluntary.setAddress(address);
        String addressLongitude=request.getParameter("addressLongitude");
        simpleVoluntary.setAddressLongitude(addressLongitude);
        String addressLatitude=request.getParameter("addressLatitude");
        simpleVoluntary.setAddressLatitude(addressLatitude);
        String voluntaryMore=request.getParameter("voluntaryMore");
        simpleVoluntary.setVoluntaryMore(voluntaryMore);
        JSONObject jsonObjectAdds= LocationUtil.getAddress(addressLongitude,addressLatitude);
        String province = jsonObjectAdds.getJSONObject("result").getJSONObject("addressComponent").getString("province");// 省
        String city = jsonObjectAdds.getJSONObject("result").getJSONObject("addressComponent").getString("city");// 市
        String district=jsonObjectAdds.getJSONObject("result").getJSONObject("addressComponent").getString("district");// 区
        simpleVoluntary.setProvince(province);
        simpleVoluntary.setCity(city);
        simpleVoluntary.setDistrict(district);
        return voluntaryService.editVoluntary(simpleVoluntary);
    }


    @ResponseBody
    @RequestMapping(value = "/findVoluntaryByTitle")
    public ResultDto findVoluntaryByTitle(HttpServletRequest request){
        String title=request.getParameter("title");
        String lng=request.getParameter("lng");
        String lat=request.getParameter("lat");
        return voluntaryService.findVoluntaryByTitle(title,lat,lng);
    }

    @ResponseBody
    @RequestMapping(value = "/findVoluntaryByDistrict")
    public ResultDto findVoluntaryByDistrict(HttpServletRequest request){
        String province=request.getParameter("province");
        String city=request.getParameter("city");
        String district=request.getParameter("district");
        String lng=request.getParameter("lng");
        String lat=request.getParameter("lat");
        return voluntaryService.findVoluntaryByDistrict(province,city,district,lat,lng);
    }
}
