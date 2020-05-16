package com.myschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.myschool.entity.ClassTeacherSubjectEntity;
import com.myschool.exceptions.SchoolNotFoundException;
import com.myschool.repository.ClassTeacherSubjectRepository;

@Service
public class ClassTeacherSubjectService {

	@Autowired
	private ClassTeacherSubjectRepository ClassTeacherSubjectrpo;

	public List<ClassTeacherSubjectEntity> getClassTeacherSubjects() {
		return ClassTeacherSubjectrpo.findAll();
	}

	public ClassTeacherSubjectEntity getClassTeacherSubject(@PathVariable Long id) {
		return ClassTeacherSubjectrpo.findById(id).orElseThrow(() -> new SchoolNotFoundException(id));
	}

	public ClassTeacherSubjectEntity saveClassTeacherSubject(ClassTeacherSubjectEntity ClassTeacherSubject) {
		return ClassTeacherSubjectrpo.save(ClassTeacherSubject);
	}

	public ClassTeacherSubjectEntity replaceClassTeacherSubject(
			@RequestBody ClassTeacherSubjectEntity newClassTeacherSubject, @PathVariable Long id) {
		return ClassTeacherSubjectrpo.findById(id).map(ClassTeacherSubject -> {
			ClassTeacherSubject.setYear(newClassTeacherSubject.getYear());
			ClassTeacherSubject.setIsActive(newClassTeacherSubject.getIsActive());
			return ClassTeacherSubjectrpo.save(ClassTeacherSubject);
		}).orElseGet(() -> {
			return ClassTeacherSubjectrpo.save(newClassTeacherSubject);
		});
	}

	public void deleteclassTeacherSubject(@PathVariable Long id) {
		ClassTeacherSubjectrpo.deleteById(id);
	}
}
