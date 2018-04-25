package data

import (
	"gopkg.in/mgo.v2"
	"os/user"
	"gopkg.in/mgo.v2/bson"
)

type UserStorage struct {
  	c *mgo.Collection
  	context *Context
  }

func (us UserStorage) Create(u *user.User) error {
	obj_ID := bson.NewObjectId()
	u.ID = obj_ID

}

func (us UserStorage) Update(u *user.User) error {
	panic("implement me")
}

func (us UserStorage) Delete(u *user.User) error {
	panic("implement me")
}

func (us UserStorage) GetAll()(user.Users, error){
	panic("implement me")
}

func (us UserStorage) GetByID(u *user.User) error {
	panic("implement me")
}
  
