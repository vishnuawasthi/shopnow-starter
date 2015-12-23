package com.shopnow.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopnow.dto.JpaSampleDTO;
import com.shopnow.entity.JpaSample;
import com.shopnow.repository.JpaSampleRepository;
import com.shopnow.utils.ValidationUtils;

public interface JpaSampleSearchService {
	
	public List<JpaSampleDTO> findByFirstName(String firstNme);
	public List<JpaSampleDTO> findByLastName(String lastName);
	public JpaSampleDTO findFirstByEmail(String email);
	
	@Service
	public class Impl implements JpaSampleSearchService{
		
		private static final Logger log = Logger.getLogger(Impl.class);
		
		@Autowired
		private JpaSampleRepository jpaSampleRepository;
		
		@Override
		public List<JpaSampleDTO> findByFirstName(String firstNme) {
			log.info("findByFirstName() - start");
			List<JpaSampleDTO> dtoList = new ArrayList<JpaSampleDTO>();
			List<JpaSample> entityList = jpaSampleRepository.findByFirstName(firstNme);
			populateDTOList(entityList, dtoList) ;
			log.info("findByFirstName() - end");
			return dtoList;
		}

		@Override
		public List<JpaSampleDTO> findByLastName(String lastName) {
			log.info("findByLastName() - start");
			List<JpaSampleDTO> dtoList = new ArrayList<JpaSampleDTO>();
			List<JpaSample> entityList = jpaSampleRepository.findByLastName(lastName);
			populateDTOList(entityList, dtoList) ;
			log.info("findByLastName() - end");
			return dtoList;
		}

		@Override
		public JpaSampleDTO findFirstByEmail(String email) {
			JpaSample entity = jpaSampleRepository.findFirstByEmail(email);
			return populateDTO(entity);
		}
		private void populateDTOList(List<JpaSample> entityList, List<JpaSampleDTO> dtoList) {
			for (JpaSample entity :  ValidationUtils.nullSafe(entityList) ) {
			JpaSampleDTO    jpaSampleDTO = new JpaSampleDTO();
							jpaSampleDTO.setId(entity.getId());
							jpaSampleDTO.setFirstName(entity.getFirstName());
							jpaSampleDTO.setLastName(entity.getLastName());
							jpaSampleDTO.setEmail(entity.getEmail());
							jpaSampleDTO.setMobile(entity.getMobile());
							jpaSampleDTO.setAddressLine1(entity.getAddressLine1());
							jpaSampleDTO.setAddressLine2(entity.getAddressLine2());
							jpaSampleDTO.setCity(entity.getCity());
							jpaSampleDTO.setState(entity.getState());
							jpaSampleDTO.setCountry(entity.getCountry());
							dtoList.add(jpaSampleDTO);
			}
		}
		
		private JpaSampleDTO populateDTO(JpaSample entity) {
			if(entity!=null) {
				JpaSampleDTO    jpaSampleDTO  =new JpaSampleDTO();
								jpaSampleDTO.setId(entity.getId());
								jpaSampleDTO.setFirstName(entity.getFirstName());
								jpaSampleDTO.setLastName(entity.getLastName());
								jpaSampleDTO.setEmail(entity.getEmail());
								jpaSampleDTO.setMobile(entity.getMobile());
								jpaSampleDTO.setAddressLine1(entity.getAddressLine1());
								jpaSampleDTO.setAddressLine2(entity.getAddressLine2());
								jpaSampleDTO.setCity(entity.getCity());
								jpaSampleDTO.setState(entity.getState());
								jpaSampleDTO.setCountry(entity.getCountry());
								return jpaSampleDTO;
			}
			return null;
		}
		

	}
	
}
