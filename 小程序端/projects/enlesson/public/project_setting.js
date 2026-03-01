module.exports = { // enlesson
	PROJECT_COLOR: '#2F7FFF',
	NAV_COLOR: '#ffffff',
	NAV_BG: '#2F7FFF',

	// setup
	SETUP_CONTENT_ITEMS: [
		{ title: '关于我们', key: 'SETUP_CONTENT_ABOUT' },
		{ title: '用户注册使用协议', key: 'SETUP_YS' }
	],

	// 用户 
	USER_FIELDS: [
		{ mark: 'sex', title: '性别', type: 'select', selectOptions: ['男', '女'], must: true },
		{ mark: 'birth', type: 'date', title: '出生年月', must: true },
		{ mark: 'college', type: 'text', title: '学院系所', must: true, min: 2, max: 200 },
		{ mark: 'major', type: 'text', title: '所学专业', must: true, min: 2, max: 200 },
		{ mark: 'item', type: 'text', title: '班级', must: true, min: 2, max: 200 },
		{ mark: 'year', type: 'year', title: '入学年份', must: true, },
		{ mark: 'no', type: 'text', title: '学号', must: true, },

	],


	NEWS_NAME: '公告通知',
	NEWS_CATE: [
		{ id: 1, title: '公告通知' },
		{ id: 2, title: '选课规则' },
		{ id: 3, title: '教师风采' },
	],
	NEWS_FIELDS: [
		{ mark: 'desc', type: 'textarea', title: '简介', must: true, min: 2, max: 200 },
		{ mark: 'content', title: '详细内容', type: 'content', must: true },
		{ mark: 'cover', type: 'image', title: '封面图', must: true, min: 1, max: 1 },
	],

	// https://mp.weixin.qq.com/s?__biz=MzUyNTE4MTg5Mg==&mid=2247497071&idx=1&sn=1db70df869d67da8b2b43f785354fdc7&chksm=fa2343c4cd54cad23be9dac5e92ba14c0e434c1a1d60cba45833457e69a9e1d02a8d16c56f27&scene=27
	ENROLL_NAME: '课程',
	ENROLL_CATE: [
		{ id: 1, title: '科学与技术' },
		{ id: 2, title: '科技实践' },
		{ id: 3, title: '健康与社会' },
		{ id: 4, title: '经济与管理' },
		{ id: 5, title: '文学与艺术' },
		{ id: 6, title: '哲学与历史' },
		{ id: 7, title: '艺术实践' },
		{ id: 8, title: '文化实践' },

	],
	ENROLL_FIELDS: [
		{ mark: 'cover', title: '封面', type: 'image', min: 1, max: 1, must: true },
		{ mark: 'college', title: '开课院系', type: 'text', must: true },
		{ mark: 'teacher', title: '任课老师', type: 'text', must: true },
		{ mark: 'cnt', title: '总课时数', type: 'int', must: true },
		{ mark: 'time', title: '教学时间', type: 'text', must: true },
		{ mark: 'score', title: '获得学分', type: 'digit', must: true },
		{ mark: 'desc', title: '课程介绍', type: 'content', must: true },
	],
	ENROLL_JOIN_FIELDS: [
		{ mark: 'name', type: 'text', title: '姓名', must: true, max: 30 },
		{ mark: 'phone', type: 'mobile', title: '手机', must: true, edit: false }
	],


}