package com.rsvt.model;

import java.util.List;


public interface RsvtDAO_interface {
		public void insert(RsvtVO rsvt);
		public void update(RsvtVO rsvt);
		public void delete(Integer rsvtId);
		public RsvtVO findByPrimaryKey(Integer rsvtId);
        public RsvtVO findByCustomerName(String customerName);

        public List<RsvtVO> getAll();

}
