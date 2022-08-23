package springcloud.service;

import com.xuanxie.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springcloud.mapper.DeptMapper;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService{
    @Autowired
    DeptMapper deptMapper;

    @Override
    public boolean addDept(Dept dept) {
        if (deptMapper.addDept(dept)==1){
            return true;
        }
        return false;
    }

    @Override
    public Dept deptById(int deptId) {
        return deptMapper.deptById(deptId);
    }

    @Override
    public List<Dept> getAllDept() {
       return deptMapper.getAllDept();
    }

    @Override
    public boolean updateDept(Dept dept) {
        if (deptMapper.updateDept(dept)==1){
            return true;
        }
        return false;
    }

    @Override
    public boolean delDeptById(int deptId) {
        if (deptMapper.delDeptById(deptId)==1){
            return true;
        }
        return false;
    }
}
