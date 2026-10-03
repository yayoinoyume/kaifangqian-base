/**
 * @description 电子印章--模板文件夹相关接口
 */
package com.kaifangqian.modules.opensign.controller;

import com.kaifangqian.annotation.ResrunLogModule;
import com.kaifangqian.modules.opensign.service.template.SignTemplateFolderRelationService;
import com.kaifangqian.modules.opensign.service.template.SignTemplateFolderService;
import com.kaifangqian.modules.opensign.service.template.SignTemplateService;
// import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: TemplateFolderController
 * @Package: com.kaifangqian.modules.sign.controller
 * @ClassName: TemplateFolderController
 * @author: FengLai_Gong
 * @Date: 2023/7/27 10:05
 */
// @Api(tags = "电子印章--模板文件夹相关接口")
@RestController
@RequestMapping("/sign/template/folder")
@Slf4j
@ResrunLogModule(name = "模板文件夹相关接口")
public class SignTemplateFolderController {


    @Autowired
    private SignTemplateFolderService templateFolderService ;
    @Autowired
    private SignTemplateFolderRelationService templateFolderRelationService ;
    @Autowired
    private SignTemplateService templateService ;






}